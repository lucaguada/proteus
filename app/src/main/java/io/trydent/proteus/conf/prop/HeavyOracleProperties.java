package io.trydent.proteus.conf.prop;

import io.trydent.proteus.conf.store.mysql.AbstractMySqlProperties;
import io.trydent.proteus.conf.store.oracle.AbstractOracleProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static io.trydent.proteus.util.Constants.Profile.*;

/**
 * Created by guada on 05/09/14.
 */
@Profile(HEAVY)
@Component
@ConfigurationProperties(prefix = HEAVY_ORACLE)
public class HeavyOracleProperties extends AbstractOracleProperties { }
