package com.epam.pricingcalc.model;

import java.util.Objects;

public class ComputeEngine {
    private String numberOfInstances;
    private String whatAreInstancesFor;
    private String operatingSystem;
    private String provisioningModel;
    private String machineFamily;
    private String machineSeries;
    private String machineType;
    private String threadsPerCore;
    private String bootDiskType;
    private String bootDiskSize;
    private boolean enableConfidentialVmService;
    private boolean addSustainedUseDiscounts = true;
    private boolean addGpus;
    private String gpuType;
    private String numberOfGpus;
    private String localSsd;
    private String datacenterLocation;
    private String instancesUsingEphemeralPublicIp;
    private String instancesUsingStaticPublicIp;
    private String committedUsage;
    private String totalEstimatedCost;

    public ComputeEngine() {
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getWhatAreInstancesFor() {
        return whatAreInstancesFor;
    }

    public void setWhatAreInstancesFor(String whatAreInstancesFor) {
        this.whatAreInstancesFor = whatAreInstancesFor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getThreadsPerCore() {
        return threadsPerCore;
    }

    public void setThreadsPerCore(String threadsPerCore) {
        this.threadsPerCore = threadsPerCore;
    }

    public String getBootDiskType() {
        return bootDiskType;
    }

    public void setBootDiskType(String bootDiskType) {
        this.bootDiskType = bootDiskType;
    }

    public String getBootDiskSize() {
        return bootDiskSize;
    }

    public void setBootDiskSize(String bootDiskSize) {
        this.bootDiskSize = bootDiskSize;
    }

    public boolean isEnableConfidentialVmService() {
        return enableConfidentialVmService;
    }

    public void setEnableConfidentialVmService(boolean enableConfidentialVmService) {
        this.enableConfidentialVmService = enableConfidentialVmService;
    }

    public boolean isAddSustainedUseDiscounts() {
        return addSustainedUseDiscounts;
    }

    public void setAddSustainedUseDiscounts(boolean addSustainedUseDiscounts) {
        this.addSustainedUseDiscounts = addSustainedUseDiscounts;
    }

    public boolean isAddGpus() {
        return addGpus;
    }

    public void setAddGpus(boolean addGpus) {
        this.addGpus = addGpus;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    public void setNumberOfGpus(String numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getInstancesUsingEphemeralPublicIp() {
        return instancesUsingEphemeralPublicIp;
    }

    public void setInstancesUsingEphemeralPublicIp(String instancesUsingEphemeralPublicIp) {
        this.instancesUsingEphemeralPublicIp = instancesUsingEphemeralPublicIp;
    }

    public String getInstancesUsingStaticPublicIp() {
        return instancesUsingStaticPublicIp;
    }

    public void setInstancesUsingStaticPublicIp(String instancesUsingStaticPublicIp) {
        this.instancesUsingStaticPublicIp = instancesUsingStaticPublicIp;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost;
    }

    public void setTotalEstimatedCost(String totalEstimatedCost) {
        this.totalEstimatedCost = totalEstimatedCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputeEngine)) return false;
        ComputeEngine that = (ComputeEngine) o;
        return enableConfidentialVmService == that.enableConfidentialVmService &&
                addSustainedUseDiscounts == that.addSustainedUseDiscounts &&
                addGpus == that.addGpus &&
                Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(whatAreInstancesFor, that.whatAreInstancesFor) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(provisioningModel, that.provisioningModel) &&
                Objects.equals(machineFamily, that.machineFamily) &&
                Objects.equals(machineSeries, that.machineSeries) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(threadsPerCore, that.threadsPerCore) &&
                Objects.equals(bootDiskType, that.bootDiskType) &&
                Objects.equals(bootDiskSize, that.bootDiskSize) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(numberOfGpus, that.numberOfGpus) &&
                Objects.equals(localSsd, that.localSsd) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(instancesUsingEphemeralPublicIp, that.instancesUsingEphemeralPublicIp) &&
                Objects.equals(instancesUsingStaticPublicIp, that.instancesUsingStaticPublicIp) &&
                Objects.equals(committedUsage, that.committedUsage) &&
                Objects.equals(totalEstimatedCost, that.totalEstimatedCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, whatAreInstancesFor, operatingSystem, provisioningModel, machineFamily, machineSeries, machineType, threadsPerCore, bootDiskType, bootDiskSize, enableConfidentialVmService, addSustainedUseDiscounts, addGpus, gpuType, numberOfGpus, localSsd, datacenterLocation, instancesUsingEphemeralPublicIp, instancesUsingStaticPublicIp, committedUsage, totalEstimatedCost);
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", whatAreInstancesFor='" + whatAreInstancesFor + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", threadsPerCore='" + threadsPerCore + '\'' +
                ", bootDiskType='" + bootDiskType + '\'' +
                ", bootDiskSize='" + bootDiskSize + '\'' +
                ", enableConfidentialVmService=" + enableConfidentialVmService +
                ", addSustainedUseDiscounts=" + addSustainedUseDiscounts +
                ", addGpus=" + addGpus +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGpus='" + numberOfGpus + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", instancesUsingEphemeralPublicIp='" + instancesUsingEphemeralPublicIp + '\'' +
                ", instancesUsingStaticPublicIp='" + instancesUsingStaticPublicIp + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", totalEstimatedCost='" + totalEstimatedCost + '\'' +
                '}';
    }
}
