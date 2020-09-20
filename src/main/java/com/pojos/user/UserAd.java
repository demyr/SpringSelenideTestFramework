package com.pojos.user;

import lombok.Data;

@Data(staticConstructor = "of")
public class UserAd {
    private String company;
    private String url;
    private String text;
}
