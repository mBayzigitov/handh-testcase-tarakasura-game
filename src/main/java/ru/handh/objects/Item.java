package ru.handh.objects;

import ru.handh.util.ParameterAffected;

public class Item {
    protected String name;
    protected String description;
    protected ParameterAffected parameterAffected;
    protected int buffValue;

    public Item() {}

    public Item(String name, String description, ParameterAffected parameterAffected, int buffValue) {
        if (name == null) {
            throw new IllegalArgumentException("Name must be not null");
        } else {
            this.name = name;
        }

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

        if (buffValue <= 0) {
            throw new IllegalArgumentException("Buff value must be above zero");
        } else {
            this.buffValue = buffValue;
        }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name must be not null");
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
