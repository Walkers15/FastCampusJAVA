package com.company.design.decorator;

public class AudiA4 extends AudiDecorator {
    public AudiA4(ICar audi, String modelName) {
        super(audi, modelName, 2000);
    }
}
