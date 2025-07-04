
package com.farmtech.farmhub.model.inbox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import tz.co.hosannahighertech.messagekit.commons.models.IUser;

public class Sender implements IUser {

    @SerializedName("names")
    @Expose
    private String names;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sender() {
    }

    /**
     * 
     * @param names
     */
    public Sender(String names) {
        super();
        this.names = names;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getAvatar() {
        return null;
    }
}
