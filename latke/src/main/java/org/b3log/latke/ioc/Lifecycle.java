/*
 * Copyright (c) 2009-2018, b3log.org & hacpai.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.latke.ioc;

import org.b3log.latke.ioc.config.Configurator;
import org.b3log.latke.logging.Level;
import org.b3log.latke.logging.Logger;

import java.util.Collection;

/**
 * The Latke bean lifecycle functions facade.
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.7, Sep 29, 2018
 * @since 2.4.18
 */
public final class Lifecycle {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Lifecycle.class);

    /**
     * Latke bean manager.
     */
    private static BeanManager beanManager;

    /**
     * Private constructor.
     */
    private Lifecycle() {
    }

    /**
     * Starts the application with the specified bean class and bean modules.
     *
     * @param classes the specified bean class, nullable
     */
    public static void startApplication(final Collection<Class<?>> classes) {
        LOGGER.log(Level.DEBUG, "Initializing Latke IoC container");

        beanManager = BeanManager.getInstance();
        final Configurator configurator = beanManager.getConfigurator();
        if (null != classes && !classes.isEmpty()) {
            configurator.createBeans(classes);
        }

        LOGGER.log(Level.DEBUG, "Initialized Latke IoC container");
    }

    /**
     * Ends the application.
     */
    public static void endApplication() {
        LOGGER.log(Level.DEBUG, "Latke IoC container ended");
    }

    /**
     * Gets bean manager.
     *
     * @return bean manager
     */
    public static BeanManager getBeanManager() {
        return beanManager;
    }
}
