package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.HandlerThread;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.ng;
import com.tencent.mm.e.a.ng.b;
import com.tencent.mm.e.b.p;
import com.tencent.mm.e.b.t;
import com.tencent.mm.pluginsdk.i.aa;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.i.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class c
  extends com.tencent.mm.ui.i<r>
  implements j.b
{
  private static long lOQ = 2000L;
  protected MMSlideDelView.f cEj;
  protected MMSlideDelView.c cEk;
  protected MMSlideDelView.e cEl;
  protected MMSlideDelView.d cEm = MMSlideDelView.bil();
  private String ckb;
  protected List<String> crs = null;
  private boolean eXQ = false;
  boolean hlt = false;
  private float lNS = -1.0F;
  private float lNT = -1.0F;
  private float lNU = -1.0F;
  private ColorStateList[] lNV = new ColorStateList[5];
  HashMap<String, d> lNW;
  private boolean lOB = true;
  private f lOC;
  private d lOD;
  boolean lOE = false;
  boolean lOF = false;
  boolean lOG = false;
  boolean lOH = false;
  c lOI;
  private com.tencent.mm.sdk.c.c lOJ = null;
  b lOK = null;
  public String lOL = "";
  final e lOM = new e();
  private final int lON;
  private final int lOO;
  private a lOP;
  private boolean lOR = false;
  com.tencent.mm.sdk.platformtools.ah lOS = new com.tencent.mm.sdk.platformtools.ah(twkvy.getLooper(), new ah.a()
  {
    public final boolean jK()
    {
      if (c.e(c.this)) {
        c.f(c.this);
      }
      return false;
    }
  }, false);
  
  public c(Context paramContext, com.tencent.mm.ui.i.a parama)
  {
    super(paramContext, new r());
    kNG = parama;
    lNV[0] = com.tencent.mm.az.a.B(paramContext, 2131689744);
    lNV[1] = com.tencent.mm.az.a.B(paramContext, 2131690081);
    lNV[3] = com.tencent.mm.az.a.B(paramContext, 2131689841);
    lNV[2] = com.tencent.mm.az.a.B(paramContext, 2131690078);
    lNV[2] = com.tencent.mm.az.a.B(paramContext, 2131690078);
    lNV[4] = com.tencent.mm.az.a.B(paramContext, 2131689767);
    lNW = new HashMap();
    if (com.tencent.mm.az.a.cY(paramContext)) {
      lOO = paramContext.getResources().getDimensionPixelSize(2131427501);
    }
    for (lON = paramContext.getResources().getDimensionPixelSize(2131427502);; lON = paramContext.getResources().getDimensionPixelSize(2131427503))
    {
      lNS = com.tencent.mm.az.a.D(paramContext, 2131427667);
      lNT = com.tencent.mm.az.a.D(paramContext, 2131427626);
      lNU = com.tencent.mm.az.a.D(paramContext, 2131427709);
      return;
      lOO = paramContext.getResources().getDimensionPixelSize(2131427500);
    }
  }
  
  private static String JA(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 32)) {
      return com.tencent.mm.pluginsdk.i.a.aTv().nC(paramString);
    }
    return null;
  }
  
  private CharSequence a(r paramr, int paramInt, boolean paramBoolean)
  {
    if ((!com.tencent.mm.platformtools.s.kf(field_editingMsg)) && ((field_atCount <= 0) || (field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(context.getString(2131233693));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(e.a(context, field_editingMsg, paramInt));
      return (CharSequence)localObject1;
    }
    Object localObject1 = field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
      return new SpannableString(e.b(context, (CharSequence)localObject1, paramInt));
    }
    localObject1 = field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      if (com.tencent.mm.platformtools.s.f((Integer)com.tencent.mm.model.ah.tE().ro().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0) {
        return context.getString(2131235089);
      }
    }
    Object localObject3;
    if (((String)localObject1).equals("tmessage"))
    {
      localObject3 = com.tencent.mm.model.ah.tE().rx().HT("@t.qq.com");
      if ((localObject3 != null) && (((am)localObject3).Rc())) {}
      for (i = 1; i == 0; i = 0) {
        return context.getString(2131235089);
      }
    }
    if (((String)localObject1).equals("qmessage"))
    {
      if ((com.tencent.mm.model.h.si() & 0x40) != 0) {}
      for (i = 1; i == 0; i = 0) {
        return context.getString(2131235089);
      }
    }
    if ((field_msgType != null) && ((field_msgType.equals("47")) || (field_msgType.equals("1048625"))))
    {
      localObject1 = JA(field_digest);
      localObject3 = "";
      if (localObject1 != null) {
        return "[" + (String)localObject1 + "]";
      }
      localObject1 = localObject3;
      if (field_digest != null)
      {
        localObject1 = localObject3;
        if (field_digest.contains(":"))
        {
          localObject3 = field_digest.substring(0, field_digest.indexOf(":"));
          String str = JA(field_digest.substring(field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject3;
          if (str != null)
          {
            paramr = "[" + str + "]";
            if (com.tencent.mm.platformtools.s.kf((String)localObject3)) {
              return paramr;
            }
            return (String)localObject3 + ": " + paramr;
          }
        }
      }
      localObject3 = context.getString(2131230896);
      if (com.tencent.mm.platformtools.s.kf((String)localObject1))
      {
        localObject1 = localObject3;
        paramr.ce((String)localObject1);
      }
    }
    else
    {
      if (com.tencent.mm.platformtools.s.kf(field_digest)) {
        break label771;
      }
      if (com.tencent.mm.platformtools.s.kf(field_digestUser)) {
        break label760;
      }
      if ((field_isSend != 0) || (!com.tencent.mm.model.i.du(field_username))) {
        break label748;
      }
      localObject1 = com.tencent.mm.model.i.A(field_digestUser, field_username);
    }
    for (;;)
    {
      label748:
      label760:
      try
      {
        localObject1 = String.format(field_digest, new Object[] { localObject1 });
        localObject3 = ((String)localObject1).replace('\n', ' ');
        if ((field_atCount <= 0) || (field_unReadCount <= 0)) {
          break label802;
        }
        paramr = new SpannableStringBuilder(context.getString(2131233690));
        paramr.setSpan(new ForegroundColorSpan(-5569532), 0, paramr.length(), 33);
        paramr.append(" ").append(e.a(context, (CharSequence)localObject3, paramInt));
        return paramr;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject3;
      break;
      localObject1 = com.tencent.mm.model.i.ej(field_digestUser);
      continue;
      localObject1 = field_digest;
      continue;
      label771:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(field_isSend, field_username, field_content, lZ(field_msgType), context);
    }
    label802:
    Object localObject2 = localObject3;
    if (paramBoolean)
    {
      localObject2 = localObject3;
      if (field_unReadCount > 1) {
        localObject2 = context.getString(2131233692, new Object[] { Integer.valueOf(field_unReadCount), localObject3 });
      }
    }
    return e.a(context, (CharSequence)localObject2, paramInt);
  }
  
  private void bnw()
  {
    ad.k(new Runnable()
    {
      public final void run()
      {
        if (!com.tencent.mm.model.ah.rg())
        {
          c.g(c.this).aZJ();
          v.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          return;
        }
        long l = com.tencent.mm.platformtools.s.Gp();
        c.h(c.this);
        l = com.tencent.mm.platformtools.s.au(l) * 3L;
        v.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(c.bnx()), Boolean.valueOf(c.e(c.this)) });
        c.ek((l + c.bnx()) / 2L);
        c.i(c.this);
        c.g(c.this).dJ(c.bnx());
      }
    });
  }
  
  private CharSequence j(r paramr)
  {
    if (field_status == 1) {
      return context.getString(2131233718);
    }
    if (field_conversationTime == Long.MAX_VALUE) {
      return "";
    }
    return com.tencent.mm.pluginsdk.i.n.c(context, field_conversationTime, true);
  }
  
  private static int lZ(String paramString)
  {
    int j = 1;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 1;
  }
  
  public void GH()
  {
    v.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(eXQ) });
    if (eXQ)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = com.tencent.mm.model.ah.tE().ru().b(com.tencent.mm.model.i.bsZ, crs, ckb);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((crs != null) && (crs.size() > 0)) {
        localArrayList1.addAll(crs);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!str.endsWith("@chatroom")) {
            localArrayList2.add(str);
          }
          v.d("MicroMsg.ConversationAdapter", "block user " + str);
        }
        if (lOC == null) {}
      }
      catch (Exception localException)
      {
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = com.tencent.mm.model.ah.tE().rr().b(ckb, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (ckb != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      return;
      setCursor(com.tencent.mm.model.ah.tE().ru().a(com.tencent.mm.model.i.bsZ, crs, com.tencent.mm.j.a.bjU, false));
    }
  }
  
  protected final void GI()
  {
    GH();
  }
  
  public final void a(int paramInt, j paramj, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      v.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramj, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    cEk = paramc;
  }
  
  public final void a(MMSlideDelView.e parame)
  {
    cEl = parame;
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    cEj = paramf;
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.h.i parami)
  {
    v.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(lOE), Boolean.valueOf(lOF), paramString });
    if ((!com.tencent.mm.platformtools.s.kf(paramString)) && (lNW != null)) {
      lNW.remove(paramString);
    }
    if (lOE)
    {
      v.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(lOR), Boolean.valueOf(lOS.baj()) });
      lOR = true;
      if (lOS.baj()) {
        bnw();
      }
      return;
    }
    lOF = true;
  }
  
  final void bnv()
  {
    if (lNW == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = lNW.entrySet().iterator();
      while (localIterator.hasNext()) {
        nextgetValuelOW = null;
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    r localr = (r)getItem(paramInt);
    String str = field_username;
    paramViewGroup = lOM;
    ajT = str;
    cFh = null;
    lPi = null;
    ble = false;
    if (!com.tencent.mm.platformtools.s.kf(str)) {
      ble = true;
    }
    lOP = new a((byte)0);
    Object localObject1;
    label385:
    Object localObject2;
    k localk;
    label493:
    boolean bool;
    label501:
    label524:
    label547:
    label591:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new g();
      if (com.tencent.mm.az.a.cY(context))
      {
        paramView = View.inflate(context, 2130903405, null);
        cui = ((ImageView)paramView.findViewById(2131755444));
        a.b.a(cui, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)cui.getDrawable();
        if (lOD != null) {
          lOD.a((d.a)localObject1);
        }
        lOb = ((NoMeasuredTextView)paramView.findViewById(2131756387));
        lOc = ((NoMeasuredTextView)paramView.findViewById(2131756388));
        lOd = ((NoMeasuredTextView)paramView.findViewById(2131756389));
        cEs = ((TextView)paramView.findViewById(2131755263));
        cEs.setBackgroundResource(com.tencent.mm.ui.tools.u.eE(context));
        lOe = ((ImageView)paramView.findViewById(2131756390));
        lOg = paramView.findViewById(2131756386);
        lOf = ((ImageView)paramView.findViewById(2131756391));
        lPj = ((ImageView)paramView.findViewById(2131756392));
        paramView.setTag(paramViewGroup);
        lOd.j(lNT);
        lOc.j(lNU);
        lOb.j(lNS);
        lOd.setTextColor(lNV[0]);
        lOc.setTextColor(lNV[4]);
        lOb.setTextColor(lNV[3]);
        lOd.liR = true;
        lOc.liR = false;
        lOb.liR = true;
        lOc.qw();
        localObject2 = (d)lNW.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new d((byte)0);
          localObject1 = lOM;
          if ((ble) && (cFh == null)) {
            cFh = com.tencent.mm.model.ah.tE().rr().GD(ajT);
          }
          localk = cFh;
          if (localk == null) {
            break label1616;
          }
          lPa = aFw;
          lOZ = ((int)bjS);
          if (localk == null) {
            break label1631;
          }
          bool = true;
          lPe = bool;
          if ((localk == null) || (!localk.oV())) {
            break label1637;
          }
          bool = true;
          lPg = bool;
          if ((localk == null) || (aFl != 0)) {
            break label1643;
          }
          bool = true;
          lPf = bool;
          ltv = com.tencent.mm.model.i.du(str);
          if ((!ltv) || (!lPf) || (field_unReadCount <= 0)) {
            break label1649;
          }
          bool = true;
          lPd = bool;
          cTv = 0;
          if ((lZ(field_msgType) == 34) && (field_isSend == 0) && (!com.tencent.mm.platformtools.s.kf(field_content)))
          {
            localObject3 = field_content;
            if (!str.equals("qmessage"))
            {
              localObject1 = localObject3;
              if (!str.equals("floatbottle")) {}
            }
            else
            {
              String[] arrayOfString = ((String)localObject3).split(":");
              localObject1 = localObject3;
              if (arrayOfString != null)
              {
                localObject1 = localObject3;
                if (arrayOfString.length > 3) {
                  localObject1 = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
                }
              }
            }
            if (!com.tencent.mm.modelvoice.ncbe) {
              cTv = 1;
            }
          }
          localObject1 = com.tencent.mm.model.i.a(localk, str, ltv);
          if ((!ltv) || (localObject1 != null)) {
            break label1655;
          }
          nickName = context.getString(2131231750);
          label807:
          lOW = j(localr);
          lOX = a(localr, (int)lOd.dIf.getTextSize(), lPd);
          lPh = field_attrflag;
        }
        switch (field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label902:
          lOY = paramInt;
          lPb = com.tencent.mm.model.i.a(localr);
          com.tencent.mm.model.ah.tE().ru();
          lNY = com.tencent.mm.storage.s.g(localr);
          if ((localk != null) && (localk.oU()))
          {
            bool = true;
            label951:
            lPc = bool;
            iZF = com.tencent.mm.sdk.platformtools.u.aZB();
            lNW.put(str, localObject2);
            localObject1 = localObject2;
            if (lOW == null) {
              lOW = j(localr);
            }
            if (!lPd) {
              break label1722;
            }
            lOd.setTextColor(lNV[0]);
            label1022:
            com.tencent.mm.booter.notification.a.h.cc(lOd.getWidth());
            com.tencent.mm.booter.notification.a.h.cd((int)lOd.dIf.getTextSize());
            com.tencent.mm.booter.notification.a.h.a(lOd.dIf);
            if (!str.toLowerCase().endsWith("@t.qq.com")) {
              break label1742;
            }
            lOb.biO();
            lOb.id(true);
            label1085:
            paramInt = lOY;
            if (paramInt == -1) {
              break label1753;
            }
            lOd.sI(paramInt);
            lOd.ic(true);
            label1112:
            lOb.setText(nickName);
            localObject2 = lOc.getLayoutParams();
            if (lOW.length() <= 9) {
              break label1764;
            }
            if (width != lOO)
            {
              width = lOO;
              lOc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1178:
            v.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(width) });
            lOc.setText(lOW);
            lOd.setText(lOX);
            if ((!ltv) || (!lPf)) {
              break label1797;
            }
            lOe.setVisibility(0);
            label1250:
            a.b.a(cui, str);
            if (lOB)
            {
              if ((localr != null) && (paramViewGroup != null) && (localObject1 != null)) {
                break label1828;
              }
              v.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            }
            if ((!lPb) && (lNY) && (com.tencent.mm.model.ah.rg())) {
              com.tencent.mm.model.ah.tE().ru().f(localr);
            }
            if ((!lNY) || (field_conversationTime == -1L)) {
              break label2148;
            }
            paramView.findViewById(2131756385).setBackgroundResource(2130838070);
            label1356:
            com.tencent.mm.av.c.aXR();
            localObject2 = new ng();
            avv.avx = true;
            com.tencent.mm.sdk.c.a.kug.y((b)localObject2);
            if ((0L != com.tencent.mm.storage.s.a(localr, 7, 0L)) && (!field_username.equals(avw.avz)))
            {
              localr.q(com.tencent.mm.storage.s.a(localr, 6, field_conversationTime));
              com.tencent.mm.model.ah.tE().ru().a(localr, field_username, true);
            }
            if ((com.tencent.mm.pluginsdk.i.a.iUZ != null) && (com.tencent.mm.pluginsdk.i.a.iUZ.xF(field_username))) {
              break label2164;
            }
            lOf.setVisibility(8);
            label1485:
            if ((com.tencent.mm.pluginsdk.i.a.iVj == null) || (!com.tencent.mm.pluginsdk.i.a.iVj.rJ(field_username))) {
              break label2217;
            }
            lPj.setVisibility(0);
          }
          break;
        }
      }
    }
    for (;;)
    {
      lOP.content = String.valueOf(lOX);
      lOP.UY = String.valueOf(nickName);
      lOP.lOV = String.valueOf(lOW);
      paramViewGroup = lOP;
      a.a.bgJ().a(paramView, UY, lOU, lOV, content);
      return paramView;
      paramView = View.inflate(context, 2130903404, null);
      break;
      paramViewGroup = (g)paramView.getTag();
      break label385;
      label1616:
      lPa = -1;
      lOZ = -1;
      break label493;
      label1631:
      bool = false;
      break label501;
      label1637:
      bool = false;
      break label524;
      label1643:
      bool = false;
      break label547;
      label1649:
      bool = false;
      break label591;
      label1655:
      nickName = e.a(context, com.tencent.mm.model.i.a(localk, str, ltv), lOb.dIf.getTextSize());
      break label807;
      paramInt = -1;
      break label902;
      paramInt = 2131165613;
      break label902;
      paramInt = -1;
      break label902;
      paramInt = 2131165612;
      break label902;
      bool = false;
      break label951;
      label1722:
      lOd.setTextColor(lNV[cTv]);
      break label1022;
      label1742:
      lOb.id(false);
      break label1085;
      label1753:
      lOd.ic(false);
      break label1112;
      label1764:
      if (width == lON) {
        break label1178;
      }
      width = lON;
      lOc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label1178;
      label1797:
      if (lPc)
      {
        lOe.setVisibility(0);
        break label1250;
      }
      lOe.setVisibility(8);
      break label1250;
      label1828:
      cEs.setVisibility(4);
      lOg.setVisibility(4);
      if (com.tencent.mm.model.i.eK(field_username))
      {
        localObject2 = lOg;
        if (field_unReadCount > 0) {}
        for (paramInt = 0;; paramInt = 4)
        {
          ((View)localObject2).setVisibility(paramInt);
          lOb.setTextColor(lNV[3]);
          break;
        }
      }
      localObject3 = lOb;
      if ((lPe) && (lPa == 1)) {}
      for (localObject2 = lNV[2];; localObject2 = lNV[3])
      {
        ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
        if ((lPe) && (lOZ != 0)) {
          break label1975;
        }
        v.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
        break;
      }
      label1975:
      if ((lPc) && (lPg))
      {
        localObject2 = lOg;
        if (field_unReadCount > 0) {}
        for (paramInt = 0;; paramInt = 4)
        {
          ((View)localObject2).setVisibility(paramInt);
          break;
        }
      }
      if ((ltv) && (lPf))
      {
        localObject2 = lOg;
        if (field_unReadCount > 0) {}
        for (paramInt = 0;; paramInt = 4)
        {
          ((View)localObject2).setVisibility(paramInt);
          break;
        }
      }
      paramInt = field_unReadCount;
      if (paramInt > 99)
      {
        cEs.setText(2131235738);
        cEs.setVisibility(0);
      }
      for (;;)
      {
        lOP.lOU = paramInt;
        break;
        if (paramInt > 0)
        {
          cEs.setText(field_unReadCount);
          cEs.setVisibility(0);
        }
      }
      label2148:
      paramView.findViewById(2131756385).setBackgroundResource(2130838071);
      break label1356;
      label2164:
      lOf.setVisibility(0);
      if (field_username.equals(avw.avz))
      {
        lOf.setImageResource(2131165875);
        break label1485;
      }
      lOf.setImageResource(2131165874);
      break label1485;
      label2217:
      lPj.setVisibility(8);
    }
  }
  
  public final void onPause()
  {
    if (cEm != null) {
      cEm.agJ();
    }
    lOE = false;
  }
  
  private final class a
  {
    public String UY;
    public String content;
    public int lOU;
    public String lOV;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  private final class c
    implements j.b
  {
    public final void a(int paramInt, j paramj, Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof String))) {
        v.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramj, paramObject });
      }
      do
      {
        return;
        paramj = (String)paramObject;
      } while ((c.a(lOT)) || (paramj == null) || (paramj.equals("")) || (c.b(lOT) == null) || (!c.b(lOT).containsKey(Integer.valueOf(paramInt))));
      c.b(lOT).remove(Integer.valueOf(paramInt));
      c.c(lOT);
    }
  }
  
  private final class d
  {
    public int cTv;
    public boolean iZF;
    public boolean lNY;
    public CharSequence lOW;
    public CharSequence lOX;
    public int lOY;
    public int lOZ;
    public int lPa;
    public boolean lPb;
    public boolean lPc;
    public boolean lPd;
    public boolean lPe;
    public boolean lPf;
    public boolean lPg;
    public int lPh;
    public boolean ltv;
    public CharSequence nickName;
    
    private d() {}
  }
  
  private final class e
  {
    String ajT = null;
    boolean ble = false;
    k cFh = null;
    Integer lPi = null;
    
    public e() {}
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public TextView cEs;
    public ImageView cui;
    public NoMeasuredTextView lOb;
    public NoMeasuredTextView lOc;
    public NoMeasuredTextView lOd;
    public ImageView lOe;
    public ImageView lOf;
    public View lOg;
    public ImageView lPj;
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */