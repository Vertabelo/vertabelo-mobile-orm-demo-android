package com.vertabelo.mobileorm.myplaces.orm.runtime.query;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Represents list of arethmetical expressions.
 */
public class CollectionAExp extends AExp {

    protected Collection<AExp> aExps;

    public CollectionAExp(Collection<AExp> aExps) {
        this.aExps = aExps;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objs) {
        sb.append(LB);

        for (Iterator<AExp> i = this.aExps.iterator(); i.hasNext();) {
            AExp exp = i.next();
            exp.build(sb, objs);
            if (i.hasNext()) {
                sb.append(COMMA);
            }
        }

        sb.append(RB);
    }
}
