Class BI.BIFinamDataCube.Fact Extends (%DeepSee.FactTable, %DeepSee.CubeFunctionSet)
{

/// Define a unique index for <property>SSN</property>.
Index SSNKey On SSN ;

ClassMethod InitParams()
{
q $$$OK
}

Xdata test()
{
<page></page>
}

}
