<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="salary.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="lbl_title" runat="server" Text="For Teacher"></asp:Label><br />
            <asp:Label ID="lbl_namet" runat="server" Text="Enter Name: "></asp:Label>
            <asp:TextBox ID="txt_namet" runat="server"></asp:TextBox><br />

            <asp:Label ID="lbl_basict" runat="server" Text="Enter Basic salary: "></asp:Label>
            <asp:TextBox ID="txt_basict" runat="server"></asp:TextBox><br />

            <asp:Label ID="lbl_hra" runat="server" Text="Enter HRA: "></asp:Label>
            <asp:TextBox ID="txt_hra" runat="server"></asp:TextBox><br />

            <asp:Button ID="teacher_submit" runat="server" Text="Calc Salary" OnClick="teacher_submit_Click" /><br />

            <asp:Label ID="lbl_output1" runat="server"></asp:Label><br /><br />



            <asp:Label ID="lbl_title2" runat="server" Text="For Doctor"></asp:Label><br />
            <asp:Label ID="lbl_named" runat="server" Text="Enter Name: "></asp:Label>
            <asp:TextBox ID="txt_named" runat="server"></asp:TextBox><br />

            <asp:Label ID="lbl_basicd" runat="server" Text="Enter Basic salary: "></asp:Label>
            <asp:TextBox ID="txt_basicd" runat="server"></asp:TextBox><br />

            <asp:Label ID="lbl_da" runat="server" Text="Enter DA: "></asp:Label>
            <asp:TextBox ID="txt_da" runat="server"></asp:TextBox><br />

            <asp:Button ID="doctor_submit" runat="server" Text="Calc Salary" OnClick="doctor_submit_Click" /><br />

            <asp:Label ID="lbl_output2" runat="server"></asp:Label>
        </div>
    </form>
</body>
</html>
