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
    @Column(name = "CD_CONS_CANAL", nullable = false)
    private Integer channelSerial;
    @Basic(optional = false)
    @Column(name = "CD_CANAL", nullable = false)
    private int channelId;
    @Basic(optional = false)
    @Column(name = "NB_CANAL", nullable = false, length = 50)
    private String channelName;
    @JsonIgnore
    @OneToMany(mappedBy = "channel")
    private List<Requirement> requirements;

    public Channel() {
    }

    public Channel(Integer channelSerial) {
        this.channelSerial = channelSerial;
    }

    public Channel(Integer channelSerial, int channelId, String channelName) {
        this.channelSerial = channelSerial;
        this.channelId = channelId;
        this.channelName = channelName;
    }

    public Integer getChannelSerial() {
        return channelSerial;
    }

    public void setChannelSerial(Integer channelSerial) {
        this.channelSerial = channelSerial;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
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
    public int hashCode() {
        int hash = 0;
        hash += (channelSerial != null ? channelSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Channel)) {
            return false;
        }
        Channel other = (Channel) object;
        return (this.channelSerial != null || other.channelSerial == null) && (this.channelSerial == null || this.channelSerial.equals(other.channelSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.Channel[ channelSerial=" + channelSerial + " ]";
    }

}
