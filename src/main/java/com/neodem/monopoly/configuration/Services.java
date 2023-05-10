package com.neodem.monopoly.configuration;

import com.neodem.monopoly.engine.BasicEngine;
import com.neodem.monopoly.engine.Engine;
import com.neodem.monopoly.objects.Board;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
@Configuration
public class Services {
    @Bean
    public Board board() {
        return new Board();
    }

    @Bean(initMethod = "start")
    public Engine engine(Board board) {
        return new BasicEngine(board);
    }
}
