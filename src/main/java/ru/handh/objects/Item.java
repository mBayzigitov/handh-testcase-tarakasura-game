package ru.handh.objects;

import ru.handh.util.ParameterAffected;

public class Item {
    protected String description;
    protected ParameterAffected parameterAffected;
    protected ParameterAffected buffType;
    protected int buffValue;

    public Item() {}

    public Item(String description, ParameterAffected parameterAffected, ParameterAffected buffType, int buffValue) {
        if (description == null) {
            throw new IllegalArgumentException("Description must be not null");
        } else {
            this.description = description;
        }

        if (parameterAffected == null) {
            throw new IllegalArgumentException("Affected parameter must be not null");
        } else {
            this.parameterAffected = parameterAffected;
        }

        if (buffType == null) {
            throw new IllegalArgumentException("Buff type must be not null");
        } else {
            this.buffType = buffType;
        }

        this.buffValue = buffValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description must be not null");
        } else {
            this.description = description;
        }
    }

    public ParameterAffected getBuffType() {
        return buffType;
    }

    public void setBuffType(ParameterAffected buffType) {
        if (buffType == null) {
            throw new IllegalArgumentException("Buff type must be not null");
        } else {
            this.buffType = buffType;
        }
    }

    public ParameterAffected getParameterAffected() {
        return parameterAffected;
    }

    public void setParameterAffected(ParameterAffected parameterAffected) {
        if (parameterAffected == null) {
            throw new IllegalArgumentException("Affected parameter must be not null");
        } else {
            this.parameterAffected = parameterAffected;
        }
    }

    public int getBuffValue() {
        return buffValue;
    }

    public void setBuffValue(int buffValue) {
        this.buffValue = buffValue;
    }
}
