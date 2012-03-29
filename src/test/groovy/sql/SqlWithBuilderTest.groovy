/*
 * Copyright 2003-2012 the original author or authors.
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
package groovy.sql

import groovy.xml.MarkupBuilder

/**
 * @author Brian McCallister
 */
class SqlWithBuilderTest extends TestHelper {
    void testSqlQuery() {
        def sql = createSql()
        println "Created ${sql}"
        def doc = new MarkupBuilder()
        doc.people {
            sql.eachRow("select * from PERSON") {
                doc.person(first: it.firstname, last: it.lastname, location: it.location_name)
            }
        }
        sql.close()
    }
}

