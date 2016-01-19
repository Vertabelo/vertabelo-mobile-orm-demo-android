package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.List;

public class FunctionAExp extends AExp {

    protected String funtionName;

    protected List<AExp> args;

    public FunctionAExp(String funtionName, List<AExp> args) {
        this.funtionName = funtionName;
        this.args = args;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        sb.append(funtionName + LB);
        int i = 0;
        for (AExp arg : args) {
            if (i++ > 0) {
                sb.append(COMMA);
            }
            arg.build(sb, objs);
        }
        sb.append(RB);
    }
}
