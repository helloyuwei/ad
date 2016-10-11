package com.yuwei.adsense.ad.template.parser;

import java.io.File;
import java.util.List;

/**
 * Created by YuWei on 2016/10/11.
 */
public interface RecommendParser<T> {
    List<T> parse(File file);
}
