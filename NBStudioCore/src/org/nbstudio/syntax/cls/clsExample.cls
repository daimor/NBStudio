Include incFile
Import importFile

/// test 
Class test.tmp Extends (%Library.Persistent, %Library.Populate) [ Abstract, not hidden, classtype = serial ]
{

/// Message Text
Property MessageText As array of %String [private];


/// Mobile Number
Property MobileNumber As %String(MAXLEN = "50", POPSPEC = "Title()") [ InitialExpression = " 123" ];

/// sad asd as
Parameter ANSWER [ Final, flags = EMPTY ] = "dqwdqw";

Index MobileNumber On MobileNumber [ Data = ( MobileNumber )];

/// sad sad 
Projection JavaClient As %Projection.Java[internal];

/// sadqwdwq dfs ds
ForeignKey FKey1(StateName) References User.StateTable(StateKey) [SqlName = _fkey1];

/// Message ID
Property MessageID As array of %Integer [private, serveronly = 1];

/// Index DateArchived On DateArchived;
Index Primary On MessageID [unique, type =index];

/// Person's age.<br>
/// This is a calculated field whose value is derived from <property>DOB</property>.
Property Age As %Integer [ Calculated, SqlComputeCode = { Set {Age}=##class(Sample.Person).CurrentAge({DOB})
 }, SqlComputeOnChange = DOB, SqlComputed ];

/// This class method calculates a current age given a date of birth <var>date</var>.
ClassMethod CurrentAge(byref date As %Date = "", output tmp ) As %Integer [ CodeMode = expression, publiclist = (a,b,c), sqlname = test_name  ]
{
$Select(date="":"",1:($ZD($H,8)-$ZD(date,8)\10000))
}

Query Roster(name As %String) As %SQLQuery [ final ]
{
    SELECT Name
    FROM ClubMember
}

Trigger OnInsert [ Event = INSERT ]
{
    // trigger code
}

/// dsad w
XData ProductionDefinition [ SchemaSpec = "http://www.person.com http://www.MyCompany.com/schemas/person.xsd" ]
    {
    <Production>
    <ActorPoolSize>2</ActorPoolSize>
    </Production>
}
 
Query ByName(name As %String = "") As %SQLQuery(CONTAINID = 1, SELECTMODE = "RUNTIME") [ SqlName = SP_Sample_By_Name, SqlProc ]
{SELECT ID, Name, DOB, SSN
FROM Sample.Person
WHERE (Name %STARTSWITH :name)
ORDER BY Name}

}
