/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint;

import io.gomint.server.GoMintServer;
import io.gomint.server.world.block.Block;
import io.gomint.world.World;
import io.gomint.world.WorldType;
import io.gomint.world.block.BlockDirt;
import io.gomint.world.block.data.DirtType;
import io.gomint.world.generator.CreateOptions;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class BlockSetBenchmark {

    private GoMintServer server;
    private World world;
    private BlockDirt log;

    @Setup
    public void init() throws IOException {
        this.server = new GoMintServer();

        this.world = this.server.createWorld("test", new CreateOptions().worldType(WorldType.IN_MEMORY));

        Block block = this.world.blockAt(50,5,50);
        this.log = block.blockType(BlockDirt.class);
    }

    @Benchmark
    public void setBlock() {
        this.log.type(DirtType.NORMAL);
    }

    @Benchmark
    public Block getBlock() {
        return this.world.blockAt(50,5,50);
    }

    @TearDown
    public void teardown() {
        this.server.shutdown();
    }

}
