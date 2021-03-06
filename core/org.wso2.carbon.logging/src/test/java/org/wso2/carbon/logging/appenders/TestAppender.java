/*
*  Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.carbon.logging.appenders;

import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

public class TestAppender extends CarbonConsoleAppender {
    private final List<LoggingEvent> log = new ArrayList<LoggingEvent>();

    @Override
    public void append(LoggingEvent loggingEvent) {
        log.add(loggingEvent);
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public List<LoggingEvent> getLog() {
        return new ArrayList<LoggingEvent>(log);
    }

    @Override
    public void push(LogRecord record) {
        LoggingEvent loggingEvent = LoggingUtils.getLogEvent(record);
        append(loggingEvent);
    }
}
