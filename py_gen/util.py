# Copyright 2013, Big Switch Networks, Inc.
#
# LoxiGen is licensed under the Eclipse Public License, version 1.0 (EPL), with
# the following special exception:
#
# LOXI Exception
#
# As a special exception to the terms of the EPL, you may distribute libraries
# generated by LoxiGen (LoxiGen Libraries) under the terms of your choice, provided
# that copyright and licensing notices generated by LoxiGen are not altered or removed
# from the LoxiGen Libraries and the notice provided below is (i) included in
# the LoxiGen Libraries, if distributed in source code form and (ii) included in any
# documentation for the LoxiGen Libraries, if distributed in binary form.
#
# Notice: "Copyright 2013, Big Switch Networks, Inc. This library was generated by the LoxiGen Compiler."
#
# You may not use this file except in compliance with the EPL or LOXI Exception. You may obtain
# a copy of the EPL at:
#
# http://www.eclipse.org/legal/epl-v10.html
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
# EPL for the specific language governing permissions and limitations
# under the EPL.

"""
Utilities for generating the target Python code
"""

import os
import of_g
import loxi_utils.loxi_utils as utils

templates_dir = os.path.join(os.path.dirname(os.path.realpath(__file__)), 'templates')

def render_template(out, name, **context):
    utils.render_template(out, name, [templates_dir], context)

def render_static(out, name):
    utils.render_static(out, name, [templates_dir])

def constant_for_value(version, group, value):
    enums = of_g.ir[version].enums
    enum = [x for x in enums if x.name == group][0]
    for name, value2 in enum.values:
        if value == value2:
            return "const." + name
    return repr(value)
