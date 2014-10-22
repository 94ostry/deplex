package com.pioost;

import com.pioost.dependency.Bindable;
import com.pioost.dependency.CalculationRule;
import com.pioost.dependency.Dependency;
import com.pioost.dependency.TextFiledBindable;
import com.sun.tracing.dtrace.Attributes;

/**
 * Created by pioost on 10/22/14.
 */
public class DependencyBuilder {

    private Bindable from;
    private CalculationRule calculationRule;
    private Bindable to;

    public DependencyBuilder from(Bindable textFiledBindable1) {

        from = textFiledBindable1;
        return this;
    }

    public DependencyBuilder rule(CalculationRule rule) {
        calculationRule = rule;
        return this;
    }

    public DependencyBuilder to(Bindable textFiledBindable2) {
        to = textFiledBindable2;
        return this;
    }

    public Dependency build()
    {
        return new Dependency( from, to, calculationRule );
    }
}
