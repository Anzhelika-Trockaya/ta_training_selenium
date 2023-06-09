package com.epam.pricingcalc.service;

import com.epam.pricingcalc.model.ComputeEngine;

public class ComputeEngineCreator {
    private final static String NUMBER_OF_INSTANCES_KEY = "testdata.computeEngine.numberOfInstances";
    private final static String WHAT_ARE_INSTANCES_FOR_KEY = "testdata.computeEngine.whatAreInstancesFor";
    private final static String OPERATING_SYSTEM_KEY = "testdata.computeEngine.operatingSystem";
    private final static String PROVISIONING_MODEL_KEY = "testdata.computeEngine.provisioningModel";
    private final static String MACHINE_FAMILY_KEY = "testdata.computeEngine.machineFamily";
    private final static String SERIES_KEY = "testdata.computeEngine.series";
    private final static String MACHINE_TYPE_KEY = "testdata.computeEngine.machineType";
    private final static String THREADS_PER_CORE_KEY = "testdata.computeEngine.threadsPerCore";
    private final static String BOOT_DISK_TYPE_KEY = "testdata.computeEngine.bootDiskType";
    private final static String BOOT_DISK_SIZE_KEY = "testdata.computeEngine.bootDiskSize";
    private final static String ENABLE_CONFIDENTIAL_VM_SERVICE_KEY = "testdata.computeEngine.enableConfidentialVmService";
    private final static String ADD_SUSTAINED_USE_DISCOUNTS_KEY = "testdata.computeEngine.addSustainedUseDiscounts";
    private final static String ADD_GPU_KEY = "testdata.computeEngine.addGpu";
    private final static String GPU_TYPE_KEY = "testdata.computeEngine.gpuType";
    private final static String NUMBER_OF_GPU_KEY = "testdata.computeEngine.numberOfGpu";
    private final static String LOCAL_SSD_KEY = "testdata.computeEngine.localSsd";
    private final static String DATACENTER_LOCATION_KEY = "testdata.computeEngine.datacenterLocation";
    private final static String INSTANCES_USING_EPHEMERAL_PUBLIC_IP_KEY = "testdata.computeEngine.instancesUsingEphemeralPublicIp";
    private final static String INSTANCES_USING_STATIC_PUBLIC_IP_KEY = "testdata.computeEngine.instancesUsingStaticPublicIp";
    private final static String COMMITTED_USAGE_KEY = "testdata.computeEngine.committedUsage";
    private final static String TOTAL_ESTIMATED_COST_KEY = "testdata.computeEngine.totalEstimatedCost";

    public static ComputeEngine withCredentialsFromProperty() {
        ComputeEngine computeEngine = new ComputeEngine();
        if (TestDataReader.resourceBundle.containsKey(NUMBER_OF_INSTANCES_KEY)) {
            computeEngine.setNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(WHAT_ARE_INSTANCES_FOR_KEY)) {
            computeEngine.setWhatAreInstancesFor(TestDataReader.getTestData(WHAT_ARE_INSTANCES_FOR_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(OPERATING_SYSTEM_KEY)) {
            computeEngine.setOperatingSystem(TestDataReader.getTestData(OPERATING_SYSTEM_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(PROVISIONING_MODEL_KEY)) {
            computeEngine.setProvisioningModel(TestDataReader.getTestData(PROVISIONING_MODEL_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(MACHINE_FAMILY_KEY)) {
            computeEngine.setMachineFamily(TestDataReader.getTestData(MACHINE_FAMILY_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(SERIES_KEY)) {
            computeEngine.setMachineSeries(TestDataReader.getTestData(SERIES_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(MACHINE_TYPE_KEY)) {
            computeEngine.setMachineType(TestDataReader.getTestData(MACHINE_TYPE_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(THREADS_PER_CORE_KEY)) {
            computeEngine.setThreadsPerCore(TestDataReader.getTestData(THREADS_PER_CORE_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(BOOT_DISK_TYPE_KEY)) {
            computeEngine.setBootDiskType(TestDataReader.getTestData(BOOT_DISK_TYPE_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(BOOT_DISK_SIZE_KEY)) {
            computeEngine.setBootDiskSize(TestDataReader.getTestData(BOOT_DISK_SIZE_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(ENABLE_CONFIDENTIAL_VM_SERVICE_KEY)) {
            computeEngine.setEnableConfidentialVmService(Boolean.parseBoolean(TestDataReader.getTestData(ENABLE_CONFIDENTIAL_VM_SERVICE_KEY)));
        }
        if (TestDataReader.resourceBundle.containsKey(ADD_SUSTAINED_USE_DISCOUNTS_KEY)) {
            computeEngine.setAddSustainedUseDiscounts(Boolean.parseBoolean(TestDataReader.getTestData(ADD_SUSTAINED_USE_DISCOUNTS_KEY)));
        }
        if (TestDataReader.resourceBundle.containsKey(ADD_GPU_KEY)) {
            computeEngine.setAddGpus(Boolean.parseBoolean(TestDataReader.getTestData(ADD_GPU_KEY)));
        }
        if (TestDataReader.resourceBundle.containsKey(GPU_TYPE_KEY)) {
            computeEngine.setGpuType(TestDataReader.getTestData(GPU_TYPE_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(NUMBER_OF_GPU_KEY)) {
            computeEngine.setNumberOfGpus(TestDataReader.getTestData(NUMBER_OF_GPU_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(LOCAL_SSD_KEY)) {
            computeEngine.setLocalSsd(TestDataReader.getTestData(LOCAL_SSD_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(DATACENTER_LOCATION_KEY)) {
            computeEngine.setDatacenterLocation(TestDataReader.getTestData(DATACENTER_LOCATION_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(INSTANCES_USING_EPHEMERAL_PUBLIC_IP_KEY)) {
            computeEngine.setInstancesUsingEphemeralPublicIp(TestDataReader.getTestData(INSTANCES_USING_EPHEMERAL_PUBLIC_IP_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(INSTANCES_USING_STATIC_PUBLIC_IP_KEY)) {
            computeEngine.setInstancesUsingStaticPublicIp(TestDataReader.getTestData(INSTANCES_USING_STATIC_PUBLIC_IP_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(COMMITTED_USAGE_KEY)) {
            computeEngine.setCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE_KEY));
        }
        if (TestDataReader.resourceBundle.containsKey(TOTAL_ESTIMATED_COST_KEY)) {
            computeEngine.setTotalEstimatedCost(TestDataReader.getTestData(TOTAL_ESTIMATED_COST_KEY));
        }
        return computeEngine;
    }
}
