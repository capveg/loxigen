//:: # Copyright 2013, Big Switch Networks, Inc.
//:: #
//:: # LoxiGen is licensed under the Eclipse Public License, version 1.0 (EPL), with
//:: # the following special exception:
//:: #
//:: # LOXI Exception
//:: #
//:: # As a special exception to the terms of the EPL, you may distribute libraries
//:: # generated by LoxiGen (LoxiGen Libraries) under the terms of your choice, provided
//:: # that copyright and licensing notices generated by LoxiGen are not altered or removed
//:: # from the LoxiGen Libraries and the notice provided below is (i) included in
//:: # the LoxiGen Libraries, if distributed in source code form and (ii) included in any
//:: # documentation for the LoxiGen Libraries, if distributed in binary form.
//:: #
//:: # Notice: "Copyright 2013, Big Switch Networks, Inc. This library was generated by the LoxiGen Compiler."
//:: #
//:: # You may not use this file except in compliance with the EPL or LOXI Exception. You may obtain
//:: # a copy of the EPL at:
//:: #
//:: # http::: #www.eclipse.org/legal/epl-v10.html
//:: #
//:: # Unless required by applicable law or agreed to in writing, software
//:: # distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
//:: # WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
//:: # EPL for the specific language governing permissions and limitations
//:: # under the EPL.
//::
//:: import itertools
//:: import of_g
//:: include('_copyright.java')

//:: include('_autogen.java')

package org.openflow.types;

import org.openflow.protocol.OFVersion;

public enum OFType {
//:: for i, msg in enumerate(all_messages):
     ${msg.constant_name}(new byte[] { ${ ", ".join( [str(msg.wire_type(version)) for version in all_versions ]) } } )${ ", " if i < len(all_messages)-1 else ";" }
//:: #endfor

    byte[] wireTypes;
    OFType(byte[] wireTypes) {
        this.wireTypes = wireTypes;
    }

    public byte getWireType(OFVersion version) {
        return this.wireTypes[version.getWireVersion()];
    }
}
