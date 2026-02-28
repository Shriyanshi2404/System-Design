package LLD_Concepts.StructuralDesignPattern.Adapter_Design_Pattern.Client;

import LLD_Concepts.StructuralDesignPattern.Adapter_Design_Pattern.Adaptee.WeightMachine;
import LLD_Concepts.StructuralDesignPattern.Adapter_Design_Pattern.Adaptee.WeightMachineForInfants;
import LLD_Concepts.StructuralDesignPattern.Adapter_Design_Pattern.Adaptor.WeightMachineAdaptor;
import LLD_Concepts.StructuralDesignPattern.Adapter_Design_Pattern.Adaptor.WeightMachineAdaptorImpl;

public class WeighingMachineDemo {

    public static void main(String[] args)
    {
        System.out.println("---- ADAPTER DESIGN PATTERN ----");
        WeightMachine weighingMachineForInfants = new WeightMachineForInfants();
        WeightMachineAdaptor weightMachineAdaptor = new WeightMachineAdaptorImpl(weighingMachineForInfants);
        System.out.println(weightMachineAdaptor.getWeightInKg());
    }
}
