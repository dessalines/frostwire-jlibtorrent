/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class set_piece_hashes_alert extends alert {
  private long swigCPtr;

  protected set_piece_hashes_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.set_piece_hashes_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(set_piece_hashes_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_set_piece_hashes_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public set_piece_hashes_alert(String id, int progress, int num_pieces) {
    this(libtorrent_jni.new_set_piece_hashes_alert(id, progress, num_pieces), true);
  }

  public int type() {
    return libtorrent_jni.set_piece_hashes_alert_type(swigCPtr, this);
  }

  public int category() {
    return libtorrent_jni.set_piece_hashes_alert_category(swigCPtr, this);
  }

  public String what() {
    return libtorrent_jni.set_piece_hashes_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.set_piece_hashes_alert_message(swigCPtr, this);
  }

  public void setId(String value) {
    libtorrent_jni.set_piece_hashes_alert_id_set(swigCPtr, this, value);
  }

  public String getId() {
    return libtorrent_jni.set_piece_hashes_alert_id_get(swigCPtr, this);
  }

  public void setProgress(int value) {
    libtorrent_jni.set_piece_hashes_alert_progress_set(swigCPtr, this, value);
  }

  public int getProgress() {
    return libtorrent_jni.set_piece_hashes_alert_progress_get(swigCPtr, this);
  }

  public void setNum_pieces(int value) {
    libtorrent_jni.set_piece_hashes_alert_num_pieces_set(swigCPtr, this, value);
  }

  public int getNum_pieces() {
    return libtorrent_jni.set_piece_hashes_alert_num_pieces_get(swigCPtr, this);
  }

  public final static int alert_type = libtorrent_jni.set_piece_hashes_alert_alert_type_get();
  public final static int static_category = libtorrent_jni.set_piece_hashes_alert_static_category_get();
}
