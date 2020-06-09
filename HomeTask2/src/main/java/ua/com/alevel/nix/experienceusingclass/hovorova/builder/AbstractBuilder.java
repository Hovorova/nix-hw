package ua.com.alevel.nix.experienceusingclass.hovorova.builder;

import java.util.Map;

import ua.com.alevel.nix.experienceusingclass.hovorova.util.BundleUtil;

public interface AbstractBuilder {

    default Map<String, String> getKeyValueMapByBundleProperties(String lang) {
        return BundleUtil.getBundleProperties(lang);
    }

    void buildDataList();
}
