package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.m.a.a;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.z;

final class w
  implements DialogInterface.OnClickListener
{
  w(t paramt, a.a parama, String paramString, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new z(2, new ao(iSc.appId, 0, "1"));
    t.a(iSa, paramDialogInterface);
    paramDialogInterface = l.a.gKd;
    if (paramDialogInterface != null)
    {
      t.a(iSa).G();
      paramDialogInterface.a(iSd, iSc.appId, iSc.type, iSe, iSc.mediaTagName, 1);
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */