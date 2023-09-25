package ru.handh.objects;

import ru.handh.util.EffectType;
import ru.handh.util.ParameterAffected;

public class Item {
    protected String description;
    protected ParameterAffected parameterAffected;
    protected EffectType effectType;
    protected int buffValue;

    public Item() {}

    public Item(String description, ParameterAffected parameterAffected, EffectType effectType, int buffValue) {
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

        if (effectType == null) {
            throw new IllegalArgumentException("Effect type must be not null");
        } else {
            this.effectType = effectType;
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

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        if (effectType == null) {
            throw new IllegalArgumentException("Effect type must be not null");
        } else {
            this.effectType = effectType;
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
