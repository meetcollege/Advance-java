using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace salary
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        class Person
        {
            public String name;
            public int basic;

            public Person()
            {
                name = "john doe";
                basic = 50000;
            }

            public Person(String name, int basic)
            {
                this.name = name;
                this.basic = basic;
            }

            public String Display()
            {
                return name;
            }
        }

        class Teacher : Person
        {
            public int hra;
            public Teacher()
            {
                hra = 10;
                name = "john doe";
                basic = 50000;
            }

            public Teacher(int hra, String name, int basic)
            {
                this.hra = hra;
                this.name = name;
                this.basic = basic;
            }

            public double Teacher_salary()
            {
                return basic + ((hra * basic) / 100);
            }

        }

        class Doctor : Person
        {
            public int da;

            public Doctor()
            {
                da = 12;
                name = "john doe";
                basic = 50000;
            }

            public Doctor(String name, int da, int basic)
            {
                this.name = name;
                this.basic = basic;
                this.da = da;
            }

            public double Doctor_salary()
            {
                return basic + ((da * basic) / 100);
            }
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }


        protected void teacher_submit_Click(object sender, EventArgs e)
        {
            if (txt_namet.Text != "" && txt_hra.Text != "" && txt_basict.Text != "")
            {
                int hra = int.Parse(txt_hra.Text);
                int basic = int.Parse(txt_basict.Text);
                String name = txt_namet.Text;
                Teacher t1 = new Teacher(hra, name, basic);
                lbl_output1.Text = "Name: " + t1.Display() + "<br/>Basic Salary: " + basic +
                    "<br/>Net salary: " + t1.Teacher_salary();
            }
            else
            {
                lbl_output1.Text = "Enter data first";
            }
        }

        protected void doctor_submit_Click(object sender, EventArgs e)
        {
            if (txt_named.Text != "" && txt_da.Text != "" && txt_basicd.Text != "")
            {
                int da = int.Parse(txt_hra.Text);
                int basic = int.Parse(txt_basicd.Text);
                String name = txt_named.Text;
                Doctor d1 = new Doctor(name, da, basic);
                lbl_output2.Text = "Name: " + d1.Display() + "<br/>Basic Salary: " + basic +
                    "<br/>Net salary: " + d1.Doctor_salary();
            }
            else
            {
                lbl_output2.Text = "Enter data first";
            }
        }
    }
}