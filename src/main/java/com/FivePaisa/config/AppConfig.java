package com.FivePaisa.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppConfig {

    public String encryptKey = "Your encryption key";

    public String key = "Your user key";

    public String appVer = "1.0";

    public String appName = "Your App Name";

    public String osName = "WEB";

    public String clientCode = "Your client code";

    public String userId = "Your userId";

    public String password = "Your password";

}
