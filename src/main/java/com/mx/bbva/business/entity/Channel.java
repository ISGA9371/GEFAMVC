/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge056_canal", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_CANAL"})
        , @UniqueConstraint(columnNames = {"NB_CANAL"})})
public class Channel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CANAL", nullable = false)
    private Integer channelId;
    @Basic(optional = false)
    @Column(name = "NB_CANAL", nullable = false, length = 50)
    private String channelName;
    @JsonIgnore
    @OneToMany(mappedBy = "channel")
    private List<Requirement> requirements;

    public Channel() {
    }

    public Channel(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;

        return channelId.equals(channel.channelId);
    }

    @Override
    public int hashCode() {
        return channelId.hashCode();
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                '}';
    }
}
