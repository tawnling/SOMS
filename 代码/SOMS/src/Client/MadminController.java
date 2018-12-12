package Client;

import Login.Login;
import Sql.Medicine_sql;
import Sql.Msupplier_sql;
import Sql.Purchase_sql;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class MadminController{
	public MadminController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button caigou;
    @FXML
    private Label tip1;
    @FXML
    private TextField mn,sn,jp,bp,num;
	
 
    public void Action1() throws Exception{
     if(mn.getText().isEmpty())
     {
    	 tip1.setText("请填写药品编号");
    	 return;
     }
     else if(sn.getText().isEmpty())
     {
    	 tip1.setText("请填写供应商编号");
    	 return ;
     }
     else if(jp.getText().isEmpty())
     {
    	 tip1.setText("请填写进价");
    	 return;
     }
     else if(bp.getText().isEmpty())
     {
    	tip1.setText("请填写标价");
    	return ;
     }
     else if(num.getText().isEmpty())
     {
    	 tip1.setText("请填写购进数量");
    	 return ;
     }
     else if(!Medicine_sql.checkid(mn.getText()))
     {
    	 tip1.setText("药品编号输入有误，查无此药品");
    	 return;
     }
     else if(!Msupplier_sql.checkid(sn.getText()))
     {
    	 tip1.setText("供应商编码输入有误，查无此供应商");
    	 return;
     }
     else 
     {
    	Medicine_sql.UpdateStock(mn.getText(),num.getText(),true);
    	Purchase_sql.Insert(mn.getText(),sn.getText(),Others.GetTime.getCurTime(),num.getText(),jp.getText(),Login.getusername());
        tip1.setText("添加成功");     
     }
    }
    
    @FXML
    private Button b1,b2;
    @FXML
    private TextField Text;
    @FXML
    private TextArea textArea;
    @FXML
    private Label tip2;
    
    public void Action21() throws Exception{
     String date = Others.GetTime.getCurTime();
     textArea.setText(Medicine_sql.getAfterdate(date));
    }
    public void Action22()throws Exception{
    	if(Text.getText().isEmpty())
    	{
    		tip2.setText("请输入阈值");
    		return ;
    	}
    	textArea.setText(Medicine_sql.getAfternum(Text.getText()));
    }
   
    @FXML
    private Button c1,c2,c3,c4;
    @FXML
    private TextField cnum,cname,caddress,cph;
    @FXML
    private Label tip3;
    
    public void Action31() throws Exception{
    	if(cnum.getText().isEmpty())
    	{
    		tip3.setText("供应商编号不能为空");
    		return ;
    	}
    	else if(!Msupplier_sql.checkid(cnum.getText()))
    	{
    		tip3.setText("供应商编码错误");
    		return ;
    	}
    	else 
    	{
    	cname.setText(Msupplier_sql.get(cnum.getText(),"S_Name"));
    	caddress.setText(Msupplier_sql.get(cnum.getText(),"S_Address"));
    	cph.setText(Msupplier_sql.get(cnum.getText(),"S_PN"));
    	tip3.setText("查询成功");
    }
    }
    
    public void Action32() throws Exception{
    	if(cnum.getText().isEmpty())
    	{
    		tip3.setText("供应商编号不能为空");
    		return ;
    	}
    	else if(!Msupplier_sql.checkid(cnum.getText()))
    	{
    		tip3.setText("供应商编码错误");
    		return ;
    	}
    	else if(cname.getText().isEmpty())
    	{
    		tip3.setText("供应商名称不能为空");
    		return;
    	}
    	else if(caddress.getText().isEmpty())
    	{
    		tip3.setText("供应商地址不能为空");
    		return ;
    	}
    	else if(cph.getText().isEmpty())
    	{
    		tip3.setText("供应商电话不能为空");
    		return ;
    	}
    	else {
    		Msupplier_sql.Update(cnum.getText(),cname.getText(),cph.getText(),caddress.getText());
    		tip3.setText("修改成功");
    	}
    }
    
    public void Action33() throws Exception{
    
    	if(cname.getText().isEmpty())
    	{
    		tip3.setText("供应商名称不能为空");
    		return;
    	}
    	else if(caddress.getText().isEmpty())
    	{
    		tip3.setText("供应商地址不能为空");
    		return ;
    	}
    	else if(cph.getText().isEmpty())
    	{
    		tip3.setText("供应商电话不能为空");
    		return ;
    	}
    	else {
    		Msupplier_sql.Insert(cname.getText(),cph.getText(),caddress.getText());    
    	    tip3.setText("添加成功");
    	}
    }
    
    public void Action34() throws Exception{
    	if(cnum.getText().isEmpty())
    	{
    		tip3.setText("供应商编号不能为空");
    		return ;
    	}
    	else if(!Msupplier_sql.checkid(cnum.getText()))
    	{
    		tip3.setText("供应商编码错误");
    		return ;
    	}
    	else {
    		Msupplier_sql.Delete(cnum.getText());
    		tip3.setText("删除成功");
    	}
    }
    
}
    