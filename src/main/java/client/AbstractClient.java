package client;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Getter
@Setter
public abstract class AbstractClient {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String clientId;



    }
