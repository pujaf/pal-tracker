package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private final String port;
    private final String memoryLimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddr;

    public EnvController( @Value("${cf.instance.index:NOT SET}") String port,
            @Value("${memory.limit:NOT SET}") String memoryLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr) {
        this.port = port;
        this.cfInstanceAddr = cfInstanceAddr;
        this.cfInstanceIndex = cfInstanceIndex;
        this.memoryLimit =memoryLimit;
    }
    @GetMapping("/env")
    public Map<String, String>  getEnv() {
        Map<String, String> map = new HashMap<>();
        map.put("PORT",port);
        map.put("MEMORY_LIMIT", memoryLimit);
        map.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        map.put("CF_INSTANCE_ADDR", cfInstanceAddr);
        return map;
    }
}
