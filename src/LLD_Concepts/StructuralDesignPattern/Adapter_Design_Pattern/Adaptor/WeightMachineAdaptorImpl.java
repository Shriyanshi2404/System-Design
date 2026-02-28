package LLD_Concepts.StructuralDesignPattern.Adapter_Design_Pattern.Adaptor;

import LLD_Concepts.StructuralDesignPattern.Adapter_Design_Pattern.Adaptee.WeightMachine;

public class WeightMachineAdaptorImpl implements WeightMachineAdaptor {
    WeightMachine weightMachine;

    public WeightMachineAdaptorImpl(WeightMachine weightMachine)
    {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg()
    {
        double weightInPound = weightMachine.getWeightInPound();
        // convert into Kg
        double weightInKg = weightInPound * 0.45;
        return weightInKg;
    }
}
