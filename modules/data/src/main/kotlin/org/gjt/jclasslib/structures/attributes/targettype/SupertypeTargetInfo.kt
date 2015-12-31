/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

package org.gjt.jclasslib.structures.attributes.targettype

import org.gjt.jclasslib.structures.InvalidByteCodeException

import java.io.DataInput
import java.io.DataOutput
import java.io.IOException

/**
 * Target info for a TypeAnnotation structure with a super class target.
 */
class SupertypeTargetInfo : TargetInfo() {

    var supertypeIndex: Int = 0

    @Throws(InvalidByteCodeException::class, IOException::class)
    override fun read(input: DataInput) {
        supertypeIndex = input.readUnsignedShort()
    }

    @Throws(InvalidByteCodeException::class, IOException::class)
    override fun write(output: DataOutput) {
        output.writeShort(supertypeIndex)
    }

    override val length: Int
        get() = 2

    override val verbose: String
        get() {
            if (supertypeIndex == 65535) {
                return "Super class ($supertypeIndex)"
            } else {
                return "<a href=\"I$supertypeIndex\">interface index $supertypeIndex</a>"
            }
        }

    override val debugMessage: String
        get() = "SupertypeTargetInfo with supertypeIndex $supertypeIndex"
}