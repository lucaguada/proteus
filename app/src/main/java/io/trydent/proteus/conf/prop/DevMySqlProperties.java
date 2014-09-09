package io.trydent.proteus.conf.prop;

import io.trydent.proteus.conf.store.mysql.AbstractMySqlProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static io.trydent.proteus.util.Constants.Profile.DEV;
import static io.trydent.proteus.util.Constants.Profile.DEV_MYSQL;

/**
 * Created by guada on 05/09/14.
 */
@Profile(DEV)
@Component
@ConfigurationProperties(prefix = DEV_MYSQL)
public class DevMySqlProperties extends AbstractMySqlProperties { }
