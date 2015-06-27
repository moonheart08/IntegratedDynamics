package org.cyclops.integrateddynamics.part.aspect.write;

import org.cyclops.integrateddynamics.core.evaluate.variable.IVariable;
import org.cyclops.integrateddynamics.core.evaluate.variable.ValueTypeBoolean;
import org.cyclops.integrateddynamics.core.part.PartTarget;
import org.cyclops.integrateddynamics.core.part.write.IPartStateWriter;
import org.cyclops.integrateddynamics.core.part.write.IPartTypeWriter;

/**
 * Write the boolean redstone level.
 * @author rubensworks
 */
public class AspectWriteBooleanRedstone extends AspectWriteBooleanBase {

    private static final IWriteRedstoneComponent WRITE_REDSTONE_COMPONENT = new WriteRedstoneComponent();

    @Override
    protected String getUnlocalizedBooleanType() {
        return "redstone";
    }

    @Override
    public <P extends IPartTypeWriter<P, S>, S extends IPartStateWriter<P>> void write(P partType, PartTarget target,
                                                                                       S state, IVariable<ValueTypeBoolean.ValueBoolean> variable) {
        ValueTypeBoolean.ValueBoolean value = variable.getValue();
        WRITE_REDSTONE_COMPONENT.setRedstoneLevel(target, value.getRawValue() ? 15 : 0);
    }

    @Override
    public <P extends IPartTypeWriter<P, S>, S extends IPartStateWriter<P>> void onDeactivate(P partType,
                                                                                              PartTarget target, S state) {
        super.onDeactivate(partType, target, state);
        WRITE_REDSTONE_COMPONENT.deactivate(target);
    }
}