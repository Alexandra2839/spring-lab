package com.learn.loosely;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Balance {
    private UUID userId;
}
