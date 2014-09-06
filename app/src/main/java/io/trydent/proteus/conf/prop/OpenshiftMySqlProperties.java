package io.trydent.proteus.conf.prop;

import io.trydent.proteus.conf.base.MySqlProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static io.trydent.proteus.util.Constants.Profile.OPENSHIFT;
import static io.trydent.proteus.util.Constants.Profile.OPENSHIFT_MYSQL;

/**
 * Created by guada on 05/09/14.
 */
@Profile(OPENSHIFT)
@Component
@ConfigurationProperties(prefix = OPENSHIFT_MYSQL)
public class OpenshiftMySqlProperties extends MySqlProperties { }
