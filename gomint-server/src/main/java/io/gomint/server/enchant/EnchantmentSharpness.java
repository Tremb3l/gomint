/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.enchant;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 9 )
public class EnchantmentSharpness extends Enchantment implements io.gomint.enchant.EnchantmentSharpness {

    /**
     * Create new enchantment smite
     *
     * @param level of this enchantment
     */
    public EnchantmentSharpness( short level ) {
        super( (short) 5, level );
    }

    @Override
    public byte getMinEnchantAbility( short level ) {
        return (byte) ( 1 + ( level - 1 ) * 11 );
    }

    @Override
    public byte getMaxEnchantAbility( short level ) {
        return (byte) ( getMinEnchantAbility( level ) + 20 );
    }

}
