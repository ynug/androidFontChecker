/*
 * Copyright (C) 2016 Jared Rummler <jared.rummler@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.jaredrummler.fontreader.complexscripts.fonts;

/**
 * <p>Optional interface which indicates that glyph positioning is supported and, if supported,
 * can perform positioning.</p>
 *
 * <p>This work was originally authored by Glenn Adams (gadams@apache.org).</p>
 */
public interface Positionable {

  /**
   * Determines if font performs glyph positioning.
   *
   * @return true if performs positioning
   */
  boolean performsPositioning();

  /**
   * Perform glyph positioning.
   *
   * @param cs
   *     character sequence to map to position offsets (advancement adjustments)
   * @param script
   *     a script identifier
   * @param language
   *     a language identifier
   * @param fontSize
   *     font size
   * @return array (sequence) of 4-tuples of placement [PX,PY] and advance [AX,AY] adjustments, in that order,
   * with one 4-tuple for each element of glyph sequence, or null if no non-zero adjustment applies
   */
  int[][] performPositioning(CharSequence cs, String script, String language, int fontSize);

  /**
   * Perform glyph positioning using an implied font size.
   *
   * @param cs
   *     character sequence to map to position offsets (advancement adjustments)
   * @param script
   *     a script identifier
   * @param language
   *     a language identifier
   * @return array (sequence) of 4-tuples of placement [PX,PY] and advance [AX,AY] adjustments, in that order,
   * with one 4-tuple for each element of glyph sequence, or null if no non-zero adjustment applies
   */
  int[][] performPositioning(CharSequence cs, String script, String language);

}
