package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Channel;
import com.mx.bbva.business.repository.ChannelRepository;
import com.mx.bbva.business.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> findAllChannels() {
        return channelRepository.findAll();
    }

    @Autowired
    public void setChannelRepository(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }
}
