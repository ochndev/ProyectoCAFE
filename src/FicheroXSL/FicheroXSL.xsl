<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<cafe_order>
    <order_id>2</order_id>
    <drinks>
        <xsl:for-each select="drink">
        <drink> 
          <name><xsl:value-of select="name"/></name>   
          <type><xsl:value-of select="type"/></type>
          <available><xsl:value-of select="available"/></available>>
        </drink>
        </xsl:for-each>
    </drinks>
</cafe_order>
</xsl:template>
</xsl:stylesheet>