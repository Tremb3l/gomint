package io.gomint.command.validator;

import com.google.common.base.Joiner;
import io.gomint.command.CommandSender;
import io.gomint.command.ParamType;
import io.gomint.command.ParamValidator;

import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
public class TextValidator extends ParamValidator {

    @Override
    public ParamType getType() {
        return ParamType.TEXT;
    }

    @Override
    public boolean hasValues() {
        return false;
    }

    @Override
    public List<String> values() {
        return null;
    }

    @Override
    public Object validate( List<String> input, CommandSender commandSender ) {
        return Joiner.on( " " ).join( input );
    }

    @Override
    public int consumesParts() {
        return -1;
    }

    @Override
    public String getHelpText() {
        return "text";
    }

}
