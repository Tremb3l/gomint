/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.emulator;

import io.gomint.emulator.client.Client;

import java.security.Security;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author geNAZt
 * @version 1.0
 */
public class BootStrap {

    private static final int AMOUNT_OF_BOTS = 1;

    public static void main( String[] args ) throws InterruptedException {
        Security.addProvider( new org.bouncycastle.jce.provider.BouncyCastleProvider() );

        ScheduledExecutorService service = Executors.newScheduledThreadPool( 8 ); // Amount of cores
        PostProcessExecutorService postProcessExecutorService = new PostProcessExecutorService();

        for ( int i = 0; i < AMOUNT_OF_BOTS; i++ ) {
            service.execute( new Runnable() {
                @Override
                public void run() {
                    Client client = new Client( service, postProcessExecutorService.getExecutor() );
                    client.connect( "multilabs.net", 19133 );
                }
            } );

            Thread.sleep( 500 );
        }
    }

}
