package com.pioost.dependency;

import java.util.List;

/**
 * Created by pioost on 10/21/14.
 */
public class Dependency {

    public Bindable from;

    public Bindable to;

    public CalculationRule rule;

    public Dependency(Bindable from, Bindable to,
        CalculationRule calculationRule) {

        this.from = from;
        this.to = to;
        this.rule = calculationRule;

        from.onValueChange( () -> { fire(); } );

    }

    public void fire()
    {
        to.setValue("Ala ma kota");


    }


}
