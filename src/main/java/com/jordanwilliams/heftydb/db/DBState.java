/*
 * Copyright (c) 2013. Jordan Williams
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jordanwilliams.heftydb.db;

import com.jordanwilliams.heftydb.state.Caches;
import com.jordanwilliams.heftydb.state.Metrics;
import com.jordanwilliams.heftydb.state.Paths;
import com.jordanwilliams.heftydb.state.Snapshots;
import com.jordanwilliams.heftydb.state.Tables;
import com.jordanwilliams.heftydb.table.Table;

import java.util.Collection;

public class DBState {

    private final Tables tables;
    private final Snapshots snapshots;
    private final Config config;
    private final Paths paths;
    private final Caches caches;
    private final Metrics metrics;

    public DBState(Collection<Table> tables, Config config, Paths paths, Caches caches, long currentSnapshotId) {
        this.snapshots = new Snapshots(currentSnapshotId);
        this.tables = new Tables(tables);
        this.config = config;
        this.paths = paths;
        this.caches = caches;
        this.metrics = new Metrics(config);
    }

    public Paths paths() {
        return paths;
    }

    public Tables tables() {
        return tables;
    }

    public Snapshots snapshots() {
        return snapshots;
    }

    public Caches caches() {
        return caches;
    }

    public Config config() {
        return config;
    }
}