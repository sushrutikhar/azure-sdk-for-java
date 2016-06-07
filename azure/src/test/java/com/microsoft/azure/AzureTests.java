/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.implementation.Azure;
import com.microsoft.azure.management.resources.Subscriptions;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.storage.StorageAccount;
import com.microsoft.azure.management.storage.implementation.api.AccountType;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AzureTests {
    private static final ServiceClientCredentials credentials = new ApplicationTokenCredentials(
            System.getenv("client-id"),
            System.getenv("domain"),
            System.getenv("secret"),
            AzureEnvironment.AZURE);
    private static final String subscriptionId = System.getenv("arm.subscriptionid");
    private Subscriptions subscriptions;
    private Azure azure, azure2;

    public static void main(String[] args) throws IOException, CloudException {
        final File credFile = new File("my.azureauth");
        Azure azure = Azure.authenticate(credFile).withDefaultSubscription();
        
        System.out.println(String.valueOf(azure.resourceGroups().list().size()));

        Azure.configure().withLogLevel(Level.BASIC).authenticate(credFile);
        System.out.println("Selected subscription: " + azure.subscriptionId());
        System.out.println(String.valueOf(azure.resourceGroups().list().size()));
        
        final File authFileNoSubscription = new File("nosub.azureauth");
        azure = Azure.authenticate(authFileNoSubscription).withDefaultSubscription();
        System.out.println("Selected subscription: " + azure.subscriptionId());
        System.out.println(String.valueOf(azure.resourceGroups().list().size()));
    }

    @Before
    public void setup() throws Exception {
        // Authenticate based on credentials instance
        Azure.Authenticated azureAuthed = Azure.configure()
                .withLogLevel(Level.BODY)
                .withUserAgent("AzureTests")
                .authenticate(credentials);

        subscriptions = azureAuthed.subscriptions();
        azure = azureAuthed.withSubscription(subscriptionId);

        // Authenticate based on file
        // this.azure2 = Azure.authenticate(new File("my.azureauth"))
        //        .withDefaultSubscription();
    }

    /**
     * Tests the network security group implementation
     * @throws Exception
     */
    @Test public void testNetworkSecurityGroups() throws Exception {
        new TestNSG().runTest(azure2.networkSecurityGroups(), azure2.resourceGroups());
    }

    /**
     * Tests the public IP address implementation
     * @throws Exception
     */
    @Test public void testPublicIpAddresses() throws Exception {
        new TestPublicIpAddress().runTest(azure2.publicIpAddresses(), azure2.resourceGroups());
    }

    /**
     * Tests the availability set implementation
     * @throws Exception
     */
    @Test public void testAvailabilitySets() throws Exception {
        new TestAvailabilitySet().runTest(azure2.availabilitySets(), azure2.resourceGroups());
    }

    /**
     * Tests the virtual network implementation
     * @throws Exception
     */
    @Test public void testNetworks() throws Exception {
        new TestNetwork().runTest(azure2.networks(), azure2.resourceGroups());
    }

    /**
     * Tests the network interface implementation
     * @throws Exception
     */
    @Test public void testNetworkInterface() throws Exception {
        new TestNetworkInterface().runTest(azure.networkInterfaces(), azure.resourceGroups());
    }

    @Test public void testVirtualMachines() throws Exception {
        new TestVirtualMachine().runTest(azure.virtualMachines(), azure2.resourceGroups());
    }

    @Test
    public void listSubscriptions() throws Exception {
        Assert.assertTrue(0 < subscriptions.list().size());
    }

    @Test
    public void listResourceGroups() throws Exception {
        Assert.assertTrue(0 < azure.resourceGroups().list().size());
    }

    @Test
    public void listStorageAccounts() throws Exception {
        Assert.assertTrue(0 < azure.storageAccounts().list().size());
    }
    
    @Test
    public void createStorageAccount() throws Exception {
        StorageAccount storageAccount = azure.storageAccounts().define("my-stg1")
                .withRegion(Region.ASIA_EAST)
                .withNewGroup()
                .withAccountType(AccountType.PREMIUM_LRS)
                .create();

        Assert.assertSame(storageAccount.name(), "my-stg1");
    }
}
