package io.trydent.proteus.conf.prop;

import io.trydent.proteus.conf.store.hsql.AbstractHsqlProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static io.trydent.proteus.util.Constants.Profile.BUILD;
import static io.trydent.proteus.util.Constants.Profile.BUILD_HSQLDB;

/**
 * Created by guada on 05/09/14.
 */
@Profile(BUILD)
@Component
@ConfigurationProperties(prefix = BUILD_HSQLDB)
public class BuildHsqlProperties extends AbstractHsqlProperties { }
