package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Authority {
    @Id @GeneratedValue
    @Column(name = "auth_num")
    private Long authNum;
    @Column(name = "auth_name")
    private String authName;
    @Column(name = "auth_cotent")
    private String authContent;
}
